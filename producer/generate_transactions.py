import csv
import argparse
import datetime
from random import choice, choices, randrange, uniform
import sys
from faker import Faker
import pathlib

fake = Faker()

    # @Column(nullable = false, name = 'account_id')
    # private long accountId;
    
    # @Column(nullable = false)
    # private Instant timestamp;

    # @Column(nullable = false)
    # private long amount;

    # public enum TransactionType {
    # 	DEPOSIT,
    # 	WITHDRAWAL
    # }
    # @Column(nullable = false)
    # @Enumerated(EnumType.STRING)
    # private TransactionType type;

    # @Column(nullable = false, name = 'is_suspicious')
    # private boolean isSuspicious;


def calculate_num_transactions(num_transactions):
    num_accounts = num_transactions
    if num_transactions >= 10:
        num_accounts = num_transactions // 10
    return num_accounts

def generate_random_timestamp_iso(date_today):
    timestamp = fake.iso8601()
    date_today = date_today.strftime('%Y-%m-%d')
    timestamp = date_today + timestamp[10:] + 'Z'
    return timestamp

def generate_random_amount():
    is_over_10000 = choices([True, False], weights=[2, 98])[0]
    if is_over_10000:
        amount = round(uniform(10000.01, 100000.00), 2)
    else:
        amount = round(uniform(0.00, 10000.00), 2)
    return amount

def generate_mock_transactions(num_transactions, num_accounts):
    transactions = []
    date_today = fake.date_between(start_date='+0d', end_date='+0d')
    for i in range(num_transactions):
        transactions.append({
            'accountId': randrange(num_accounts),
            'timestamp': generate_random_timestamp_iso(date_today),
            'amount': generate_random_amount(),
            'type': choice(['deposit', 'withdrawal'])
            })
    return transactions

def write_transactions_to_csv(transactions):
    with open('../src/main/resources/data/transactions.csv', 'w') as csvfile:
        writer = csv.DictWriter(csvfile, fieldnames={'accountId', 'timestamp', 'amount', 'type'})

        writer.writeheader()
        writer.writerows(transactions)

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Generate mock bank transactions.')
    parser.add_argument('num_transactions', type=int, help='Number of transactions to generate.')
    args = parser.parse_args()
    print(f'Generating {args.num_transactions} transactions...')

    num_accounts = calculate_num_transactions(args.num_transactions)
    transactions = generate_mock_transactions(args.num_transactions, num_accounts)
    write_transactions_to_csv(transactions)
