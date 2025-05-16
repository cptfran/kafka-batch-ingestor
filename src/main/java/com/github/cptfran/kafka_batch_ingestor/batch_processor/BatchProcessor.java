package main.java.com.github.cptfran.kafka_batch_ingestor.batch_processor;

import java.beans.BeanProperty;

@Configuration
public class BatchProcessor {
	@Bean
	public FlatFileItemReader<Transaction> transactionItemReader() {
    	return new FlatFileItemReaderBuilder<Transaction>()
            .name("transactionItemReader")
            .resource(new ClassPathResource("data/transactions.csv"))
            .delimited()
            .names("accountId", "timestamp", "amount", "type")
            .fieldSetMapper(fieldSet -> {
                Transaction transaction = new Transaction();
                transaction.setAccountId(fieldSet.readLong("accountId"));
                transaction.setTimestamp(fieldSet.readString("timestamp"));
                transaction.setAmount(fieldSet.readDouble("amount"));
                transaction.setType(fieldSet.readString("type"));
                return transaction;
            })
            .build();
    }

    @Bean
    public ItemProcessor<Transaction> transactionProcessor() {
        return transaction -> {
            @Value("${app.suspicious.threshold}")
            double threshold;

            transaction.setIsSuspicious(transaction.getAmount() > threshold);

            return transaction;
        };
    }
}
