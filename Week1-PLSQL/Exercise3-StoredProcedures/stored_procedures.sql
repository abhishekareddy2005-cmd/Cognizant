-- Accounts table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER
);

-- Employees table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER
);

-- Insert sample data
INSERT INTO Accounts VALUES (1, 1, 'Savings', 5000);
INSERT INTO Accounts VALUES (2, 2, 'Savings', 8000);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 3000);

INSERT INTO Employees VALUES (1, 'Rahul', 'IT', 50000);
INSERT INTO Employees VALUES (2, 'Neha', 'IT', 60000);
INSERT INTO Employees VALUES (3, 'Kiran', 'HR', 45000);

COMMIT;



-- Scenario 1: Process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts');
END;
/

-- Run it
EXEC ProcessMonthlyInterest;


-- Scenario 2: Update employee bonus by department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || p_department);
END;
/

-- Run it
EXEC UpdateEmployeeBonus('IT', 10);


-- Scenario 3: Transfer funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- check balance first
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;
    
    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance');
    ELSE
        -- deduct from source
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;
        
        -- add to destination
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful: $' || p_amount || 
        ' transferred from Account ' || p_from_account || 
        ' to Account ' || p_to_account);
    END IF;
END;
/

-- Run it
EXEC TransferFunds(1, 2, 1000);
