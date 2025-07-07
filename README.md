🔐 Cryptographic Algorithms Comparison
📘 Description
This Java project demonstrates and compares the performance of different cryptographic techniques, including:

Symmetric Encryption using AES and DES

Asymmetric Encryption using RSA

Hashing using SHA-256 and MD5

Each algorithm is measured in terms of encryption/decryption speed or hashing time, using System.nanoTime() for nanosecond-level precision.

⚙️ Features
AES Encryption/Decryption

DES Encryption/Decryption

RSA KeyPair-based Asymmetric Encryption/Decryption

SHA-256 Hashing

MD5 Hashing

Execution time measurement for performance comparison

🧪 Sample Input
The input string used for all operations is:

arduino
Copy
Edit
"Hello, Cryptography!"
📦 Output (Sample)
sql
Copy
Edit
--- AES Encryption/Decryption ---
Encrypted Data: sqs6TxZ3...
Encryption Time: 123456 ns
Decrypted Data: Hello, Cryptography!
Decryption Time: 789012 ns

--- DES Encryption/Decryption ---
...

--- RSA Encryption/Decryption ---
...

--- SHA-256 Hashing ---
Hashed Data: a592a1c5...
Hashing Time: 65432 ns

--- MD5 Hashing ---
...
🚀 How to Run
1. Compile the Program
Make sure you have JDK installed (Java 8 or higher):

bash
Copy
Edit
javac CryptographicComparison.java
2. Run the Program
bash
Copy
Edit
java Cryptographic_Algorithms.CryptographicComparison
📁 Project Structure
Copy
Edit
Cryptographic_Algorithms/
├── CryptographicComparison.java
🧠 Concepts Demonstrated
Algorithm	Type	Strengths	Weaknesses
AES	Symmetric	Fast, Secure, Widely used	Key distribution problem
DES	Symmetric	Historical relevance	Weak (56-bit key), not recommended
RSA	Asymmetric	Secure key exchange	Slower, CPU intensive
SHA-256	Hashing	Secure, widely used for integrity	Not reversible
MD5	Hashing	Fast, legacy	Vulnerable to collisions

📚 Dependencies
Java Cryptography Extension (JCE)

No external libraries used — purely Java SE

