
# 📈 Stock Trading Platform

## 📌 Project Description

**Stock Trading Platform** is a Java-based desktop application that simulates a basic stock trading environment.

This project allows users to log in, view available market stocks, buy and sell stocks, and manage their investment portfolio. Users can also view their transaction history and track their portfolio information.

The project is developed using **Java and Object-Oriented Programming (OOP) concepts**. A graphical user interface is created using **Java Swing** to make the application easy to use.

The project also uses **File I/O** to store portfolio data in a file.

---

## 🎯 Project Objectives

The main objectives of this project are:

* To simulate a basic stock trading environment.
* To display stock market data.
* To allow users to buy stocks.
* To allow users to sell stocks.
* To manage user portfolios.
* To display transaction history.
* To track stock holdings.
* To apply Object-Oriented Programming concepts.
* To use Java Swing for graphical user interface development.
* To store portfolio data using File I/O.

---

## ✨ Features

### 🔐 User Login

The application provides a login interface for users.

Users can enter their login details and access the stock trading platform.

---

### 📊 Market Data Display

The market section displays available stock information.

Users can view:

* Stock symbol
* Company name
* Stock price
* Available market stocks

This helps users make decisions before buying or selling stocks.

---

### 💰 Buy Stocks

Users can buy stocks from the market.

The application allows the user to select a stock and enter the required quantity.

The total transaction amount is calculated based on:

```text
Stock Price × Quantity
```

After a successful purchase, the stock is added to the user's portfolio.

---

### 📉 Sell Stocks

Users can sell stocks from their portfolio.

The application checks whether the user owns the required number of shares before completing the transaction.

After selling:

* Shares are removed from the portfolio.
* The transaction is recorded.
* The portfolio is updated.

---

### 📁 Portfolio Management

The portfolio section displays the stocks owned by the user.

It helps users track their current stock holdings.

The portfolio includes information such as:

* Stock symbol
* Number of shares
* Stock price
* Portfolio value

---

### 🧾 Transaction History

The transaction section displays the user's trading activities.

It records:

* Buy transactions
* Sell transactions
* Stock details
* Quantity
* Transaction price

This helps users track their previous trading operations.

---

### 💾 File I/O

The project uses **File I/O** to save portfolio data.

Portfolio information is stored in:

```text
data/portfolio.txt
```

This allows portfolio data to be stored and managed using files.

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Object-Oriented Programming (OOP)**
* **Java File I/O**
* **Java Collections**
* **Visual Studio Code**
* **Git**
* **GitHub**

---

## 📂 Project Structure

```text
StockTradingPlatform
│
├── src
│   ├── Main.java
│   ├── LoginFrame.java
│   ├── DashboardFrame.java
│   ├── MarketPanel.java
│   ├── PortfolioPanel.java
│   ├── TransactionPanel.java
│   ├── Stock.java
│   ├── User.java
│   ├── Portfolio.java
│   ├── Transaction.java
│   ├── Market.java
│   └── FileManager.java
│
└── data
    └── portfolio.txt
```

---

## 🧩 File Description

### 📌 Main.java

`Main.java` is the starting point of the application.

It launches the Stock Trading Platform.

---

### 📌 LoginFrame.java

`LoginFrame.java` provides the login interface for the user.

It allows the user to enter login details and access the application.

---

### 📌 DashboardFrame.java

`DashboardFrame.java` represents the main dashboard of the application.

It provides access to different sections of the platform.

---

### 📌 MarketPanel.java

`MarketPanel.java` displays available market stocks and their prices.

Users can use this panel to view market information and perform trading operations.

---

### 📌 PortfolioPanel.java

`PortfolioPanel.java` displays the stocks owned by the user.

It helps users view and manage their portfolio.

---

### 📌 TransactionPanel.java

`TransactionPanel.java` displays the transaction history of the user.

It shows previous buy and sell operations.

---

### 📌 Stock.java

`Stock.java` represents a stock in the market.

It stores stock-related information such as:

* Stock symbol
* Stock name
* Stock price

---

### 📌 User.java

`User.java` represents the user of the stock trading platform.

It stores user-related information.

---

### 📌 Portfolio.java

`Portfolio.java` manages the stocks owned by the user.

It keeps track of stock holdings and portfolio information.

---

### 📌 Transaction.java

`Transaction.java` represents a stock transaction.

It stores information about buying and selling stocks.

---

### 📌 Market.java

`Market.java` manages the available market stocks.

It provides stock market data to the application.

---

### 📌 FileManager.java

`FileManager.java` is responsible for file operations.

It saves and loads portfolio data using File I/O.

---


## 🖥️ Application Workflow

```text
User
  ↓
Login
  ↓
Dashboard
  ↓
Market Data
  ↓
Buy / Sell Stocks
  ↓
Portfolio Update
  ↓
Transaction History
  ↓
Save Portfolio Data
```

---

## 📊 Sample Application Features

The application provides the following sections:

```text
Login
   ↓
Dashboard
   ├── Market
   ├── Portfolio
   └── Transactions
```

---

## 🔒 Error Handling

The application handles common errors such as:

* Invalid login details.
* Invalid stock selection.
* Invalid quantity.
* Selling stocks that are not available in the portfolio.
* Invalid user input.

---

## 🚀 Future Enhancements

The following features can be added in the future:

* Real-time stock market data.
* Database connectivity using MySQL.
* User registration.
* Multiple user accounts.
* Advanced portfolio performance charts.
* Profit and loss analysis.
* Stock price history.
* Admin panel.
* Online trading API integration.

---

## 📚 Learning Outcomes

Through this project, we learned:

* How to develop a Java desktop application.
* How to use Java Swing.
* How to apply Object-Oriented Programming concepts.
* How to create and use classes and objects.
* How to manage stocks and portfolios.
* How to implement buy and sell operations.
* How to manage transactions.
* How to use File I/O.
* How to organize a Java project.

---

