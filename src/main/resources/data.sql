INSERT INTO OPERATIONS_TYPES (Operation_Type_ID, Description)
VALUES (1, 'COMPRA A VISTA');

INSERT INTO OPERATIONS_TYPES (Operation_Type_ID, Description)
VALUES (2, 'COMPRA PARCELADA');

INSERT INTO OPERATIONS_TYPES (Operation_Type_ID, Description)
VALUES (3, 'SAQUE');

INSERT INTO OPERATIONS_TYPES (Operation_Type_ID, Description)
VALUES (4, 'PAGAMENTO');

INSERT INTO Accounts(Account_ID, Document_Number)
VALUES (1, '12345678900');

INSERT INTO Accounts(Account_ID, Document_Number)
VALUES (2, '00987654321');

INSERT INTO Transactions(Transaction_ID, Amount, Event_Date, Account_ID, Operation_Type_ID)
VALUES (1, -23.54, CURRENT_TIMESTAMP(), 1, 1);

INSERT INTO Transactions(Transaction_ID, Amount, Event_Date, Account_ID, Operation_Type_ID)
VALUES (2, -33.12, CURRENT_TIMESTAMP(), 1, 2);

INSERT INTO Transactions(Transaction_ID, Amount, Event_Date, Account_ID, Operation_Type_ID)
VALUES (3, 12.47, CURRENT_TIMESTAMP(), 1, 4);
