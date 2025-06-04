# Credit Card Number Validator

A simple Java application that validates credit card numbers using the **Luhn algorithm** and identifies the **card network type** based on the first digit.

---

## 📌 Features

* ✅ Validates credit card numbers using the [Luhn algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm)
* 🏦 Detects card network (e.g., Visa, Mastercard, American Express, etc.)
* 📤 Displays formatted results including card number, validity status, and card type

---

## 🛠️ How It Works

### 1. **Luhn Algorithm Check**

The program:

* Doubles every second digit from the right (excluding the check digit).
* If doubling results in a number > 9, the digits are added together (e.g., 12 → 1 + 2 = 3).
* Sums all digits.
* If the total is divisible by 10, the card is valid.

### 2. **Card Network Detection**

Based on the **first digit** of the card number:

| First Digit | Card Network/Industry             |
| ----------- | --------------------------------- |
| 1, 2        | Air travel, financial services    |
| 3           | American Express                  |
| 4           | Visa                              |
| 5           | Mastercard                        |
| 6           | Discover                          |
| 7           | Petroleum                         |
| 8           | Healthcare and telecommunications |
| 9           | Government and “other”            |

---

## 💻 Example Output

```
**********************************************************
				Credit Card Validator
Credit Card Number: 79927398713
Valid or Invalid: VALID
Card Network: Air travel, financial services
**********************************************************
```

---

## 📦 How to Run

```bash
# 1. Clone the repository
git clone https://github.com/nisSubba2024/credit-card-validator.git
cd credit-card-validator

# 2. Compile the Java file
javac -d out src/main/java/creditcard/CardValidator.java

# 3. Run the program
java -cp out creditcard.CardValidator
```

---

## 🔪 Sample Test Card Numbers

| Card Number        | Valid | Notes                                   |
| ------------------ | ----- | --------------------------------------- |
| `79927398713`      | ✅     | Classic test number for Luhn validation |
| `4111111111111111` | ✅     | Visa                                    |
| `1234567890123456` | ❌     | Invalid card                            |

---

## 🗃️ File Structure

```
credit-card-validator/
├── src/
│   └── main/
│       └── java/
│           └── creditcard/
│               └── CardValidator.java
├── README.md
```

