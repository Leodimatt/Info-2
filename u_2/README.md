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

$f(n) = lg n$

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

## Aufgabe 3
### a)
$$
f(n) = n^2, f \in O(2^n) 
$$
Vermutung: $n^2\leq c*2^n$
Umformung: $n^2\leq c*2^n-1$
Induktionsanfang:
$$
\begin{aligned}
n_{0}=5, 5^2\geq2^{5-1} \\
n_{0}=6, 6^2\geq 2^{6-1} \\
n_{0}=7, 7^2\geq 2^{7-1}
\end{aligned}
$$
Vorraussetzung:
Für ein festen $n\geq_{7}$ gilt: $n^2\leq 2^{n-1}$
Induktionsschritt:
$$
\begin{aligned}
(n+1)^2\leq 2^n \\
(n+1)^2=n^2+2n+1 \\
n^2+2n+1\leq 2^n \\
2^{n-1}+2n+1\leq 2^n \\ \\
\text{Für 7:} \\
2^{7-1}+2*7+1\leq 2^7\\
79\leq128
\end{aligned}
$$
Skript zum überprüfen:
```py
for i in range(7, 100):
	print(2**(7-1)+2*7+1 <= 2**7)
```
### b)
$f(x)=\ln x$
$f\in O(\sqrt{ x })$
$$
\begin{aligned}
\lim_{ n \to \infty }\frac{\ln x}{\sqrt{ x })} \\
\lim_{ n \to \infty } \frac{\frac{1}{x}}{\frac{1}{2\sqrt{ x }}} = 0
\end{aligned}
$$

Aufg.4
a) Multiple3
public static int multiple3(int n) {
if (n == 0) {
return 0; // Wenn n=0, dann 3*0 = 0
}
int result = 3; // Startwert: "3" für n=1
while (n > 1) {
result += 3; // addiert 3 für jede weitere Einheit
n--;         // verringert n um 1
}
return result;   // gibt das Endergebnis zurück
}
- Zeile 1-2  ("if n == 0 then return 0")  hat konstante Kosten: Θ(1).
- Zeile 3  ("result ← 3")  ebenfalls konstante Kosten: Θ(1).
- Die Schleife  (Zeilen 4-6)  wird ungefähr n Mal durchlaufen.

  Pro Durchlauf:
    - Addition von 3 auf result (Zeile 5): konstante Kosten Θ(1)
    - Verkleinern von n um 1 (Zeile 6): konstante Kosten Θ(1)
- Die Gesamtkosten der Schleife sind damit Θ(n).
  Antwort: Multiple3 hat im schlechtesten Fall eine Komplexität von Θ(n).
