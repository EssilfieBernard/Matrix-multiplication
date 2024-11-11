When multiplying a matrix A of dimensions (n, m) with a matrix B of dimensions (m, P) , we obtain a matrix C of dimensions (n, P) :     A(n,m) * B(m,p) = C(n,p)
Matrix multiplication is performed by multiplying the components of the two matrices row by column:
Example:
/       \     /     \      /                                     \
| a b c |     | p q |      | a*p + b*r + c*t     a*q + b*s + c*u |
| e f g |  *  | r s |  =   | e*p + f*r + g*t     e*q + f*s + g*u |
| h i j |     | t u |      | h*p + i*r + j*t     h*q + i*s + j*u |
| k l m |     \     /      | k*p + l*r + m*t     k*q + l*s + m*u |
\       /                  \                                     /
Write a program that performs the multiplication of two matrices A and B taken from the user. The result of the multiplication will be stored in a third matrix C, which will then be displayed.
sample input:
Matrix A: 2,3
12 2 4
10 1 1

Matrix B: 3,2
2 2
1 2
1 1
Expected output:
Matrix C:

| 30  32 |
| 22  23 |
