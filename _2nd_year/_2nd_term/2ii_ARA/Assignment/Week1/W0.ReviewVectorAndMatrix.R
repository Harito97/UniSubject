#1. Simple operator
23+5

23-5

23*5

23/5

23^5

sqrt(5)

pi

exp(4)

log(4)  #ln(4)

log10(4)

#2. Vector
x = c(7,3,9)  #define vector x 

x/3

sum(x)

sum(x^2)

var(x)  #variance

sd(x) #= sqrt(variance)

mean(x) #average

length(x)

a = sort(x)
b = sort(x, decreasing = TRUE) -8
b

min(x, b)
max(x, b)


a = seq(1:8)
a
#> a
#[1] 1 2 3 4 5 6 7 8

seq(4,6,length = 6)
rep(c(3,2,4),4) #repeat

#3. Matrix
A = matrix(c(1:21), 3)
A
B = matrix((1:6), 2)
B
BA = B%*%A
BA

t(A)

C = matrix((1:4), 2, 2)
solve(C)
det(C)
#det(A) will error as A not a square matrix

#...

#4. Count operator
prod(4, 7)  # 4*7
prod(4:1)   # 4*3*2*1

choose(5,4) #5C4

#5. Probability & density & plot of destribution of random variable
