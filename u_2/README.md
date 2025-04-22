## Aufgabe 1
### a) 

| t   | in $\mu s$       |
| --- | ---------------- |
| 1s  | $1*10^6$         |
| 1m  | $6*10^7$         |
| 1h  | $3.6*10^9$       |
| 1d  | $8.64*10^{10}$   |
| 1a  | $3.1536*10^{13}$ |
In Java kann "Int" Zahlen bis zu 32-Bit beinhalten, wobei "Long" Zahlen bis 64-Bit beinhalten kann. Dadurch kann bis $1m$ in $\mu s$ noch in Int erstellt werden, alles drüber müsste mit Long erstellt werden.
### b)
$f(n) =n$
Das größte n ist hier $n=t$
$$
f(n)=\log_{2} n; \log_{2} n \leq t\implies n\leq 2^t
$$
Also ist das größte n hier $n=2^t$
$f(n) = n^3$
$$
n^3\leq t \implies n \leq \sqrt[3]{t }
$$
Das größte n ist hier $n=\sqrt[3]{t }$
$f(n)=2^n$
$$
2^n\leq t \implies n \leq \log_{2} t
$$
Das größte n ist hier leider nur $n=\log_{2}t$
