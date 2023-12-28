#BTVN: Mo hinh dung Y = 3 + 2X
#Sinh ra 100 bo (X, Y) theo cach sau:
#1. Lay 100 gia tri cua X tu pp chuan N(1; 1)
#2. Lay 100 gia tri sai so e tu pp chuan N(0; 0.04)
#3. Tao 100 gia tri cua Y tu mo hinh dung cong them e
# Tu 100 bo gia tri (X, Y) duoc tao, hay uoc luong mo hinh Y = a_0 + a_1*X +e

#Y = 3 + 2*X
?rnorm
#rnorm(n, mean = 0, sd = 1)
#dua ra n quan sat cua bnm x thoa man X ~ N(mean,sd^2)
set.seed(1) #co dinh bo gia tri dc sinh ra
x = rnorm(100, 1, sqrt(1))
x
e = rnorm(100, 0, sqrt(0.04))
y = 3 + 2 * x + e
lm(y ~ x)
summary(lm(y ~ x))

?dnorm
plot(x, dnorm(x, 1, 1))

################################################################################
#Run 3.6. Lap in book
library(MASS)
library(ISLR)
fix(Boston)
names(Boston)
#Cach 1. Show the dataset 
lmfit = lm(medv~lstat, data = Boston)
lmfit
#Cach 2. Use $
lmfit = lm(Boston$medv~Boston$lstat)
lmfit
#Cach 3. Use attach
attach(Boston)
lmfit = lm(medv~lstat)
lmfit
summary(lmfit)

#Kiem dinh xem sai so co tuan 1.theo pp chuan voi 2.gia tri trung binh = 0 hay k?
e = lmfit$residuals
#Bai toan 1: Kiem dinh xem co theo pp chuan k? voi H0: theo pp chuan | H1: k theo pp chuan
shapiro.test(e) 
#Do p-value < 0.05 nen bac bo H0
#KL: Voi myn 5% thi co co so de noi e khong tuan theo pp chuan

#Bai toan 2: Kiem dinh ve gia tri trung binh 
#(neu bai toan 1 cho e la pp chuan)
# ? Gia tri trung binh co = 0 khong
t.test(e, mu = 0) #neu e tuan theo pp chuan
#Bt: H0: E[e] = 0 vs H1: E[e] != 0
#Do p-value > 0.05 nen khong du co so de bac bo H0
#KL: Voi myn = 5% khong co co so de noi gia tri tb cua e khac 0

#Bai toan: Kiem dinh xem cac he so hoi quy co khac 0 khong?
# Y = alpha + beta * X
lmfit = lm(medv~lstat)
summary(lmfit)
#Bt1: Kiem dinh cho alpha. 
# H0: alpha = 0 | H1: alpha != 0
#Do p-value < 2.2 * 10^(-16) < 0.05 -> bac bo H0
#KL: Voi myn 5%, co co so de noi alpha = 0
# Neu alpha = 0 thi viet lai mo hinh hoi quy tuyen tinh Y = beta * X
lmfit1 = lm(medv ~ lstat + 0) #co +0 de khong in ra he so = 0
lmfit1

#Muon in ra he so cua mo hinh hoi quy tuyen tinh (cac uoc luong ve mo hinh)
#C1:
coef(lmfit)
#C2:
lmfit$coefficients
#C3:
lmfit$coef

#Muon xem khoang tin cay cho cac he so
confint(lmfit)

#Du doan gia tri cu the va khoang tin cay cho gia tri trung binh 
#cua medv khi biet gia tri
#cua lstat dua vao mo hinh hoi quy da cho
predict(lmfit ,data.frame(lstat=(c(5,10 ,15))),
         interval ="confidence")

#Du doan gia tri cu the va khoang tin cay cho gia tri thuc
#cua medv khi biet gia tri
#cua lstat dua vao mo hinh hoi quy da cho
predict(lmfit ,data.frame(lstat=(c(5,10 ,15))),
         interval ="prediction")

#Ve do thi 2 bien
plot(lstat, medv) #ve bieu do tan xa (dam may diem)
abline(lmfit) #dua ra duong thang hoi quy theo gia tri dc tinh trong lmfit

#Bo sung chut mau me cho do thi
abline (lmfit ,lwd =3)  #de duong thang hoi quy dam hon
abline (lmfit ,lwd=3,col ="red")  #to duong thang hoi quy bang mau do
plot(lstat ,medv ,col="red")  #chuyen mau dam may diem thanh mau red
plot(lstat ,medv ,pch =20)
plot(lstat ,medv ,pch ="+")
plot(1:20,1:20,pch =1:20)

#Chia khung do thi thanh 2 hang va 2 cot -> co the ve duoc 4 do thi (2x2=4)
par(mfrow = c(2,2))

