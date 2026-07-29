-- Create tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE
);

-- Insert sample data
INSERT INTO Customers VALUES (1, 'Amit Sharma', 65, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Priya Singh', 45, 8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'Ravi Kumar', 70, 12000, 'FALSE');
INSERT INTO Customers VALUES (4, 'Sunita Rao', 30, 5000, 'FALSE');

INSERT INTO Loans VALUES (1, 1, 10, SYSDATE + 20);
INSERT INTO Loans VALUES (2, 2, 8, SYSDATE + 60);
INSERT INTO Loans VALUES (3, 3, 9, SYSDATE + 10);
INSERT INTO Loans VALUES (4, 4, 7, SYSDATE + 100);

COMMIT;


-- Scenario 1: Apply 1% discount to loan interest for customers above 60
DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied for Customer: ' || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP flag for customers with balance over 10000
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' is now VIP');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in next 30 days
DECLARE
    CURSOR c_loans IS
        SELECT c.Name, l.DueDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate <= SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || 
        ', your loan is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
