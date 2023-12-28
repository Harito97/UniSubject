#Call neccesscy library
library(MASS)
library(ISLR)

#Simple Linear Regression

#MASS library has Boston data set
fix(Boston)     #Hien ra dataset Boston
names(Boston)   #Hien ra cac truong du lieu

?Boston         #Gioi thieu khai quat ve dataset Boston


# We will seek to predict
#medv using 13 predictors such as rm (average number of rooms per house),
#age (average age of houses), and lstat (percent of households with low
#socioeconomic status).

# Use the lm() function to fit a simple linear regression model
# Thuc hien lenh hoi quy tuyen tinh
# Cach1.
attach(Boston)
lm.fit=lm(medv~lstat)
# Cach2.
lm.fit=lm(medv~lstat, data=Boston)

# In ra thong tin he so
# Cach1.
lm(formula = medv~lstat)
# Cach2.
lm.fit

# Tom tat nhung thong tin quan trong de danh gia mo hinh
summary(lm.fit)
# Giai thich ket qua ham summary
# 1. Phan du (a boxplot about residuals)
# 2. He so cua mo hinh
#     Uoc luong  |  Do lech chuan sai so e  | t_value | Pr(>|t|)
#   a0                                                | (cang lon cang tot)
#   a1                                                | (cang nhieu * cang tot)

# 3. Do lech chuan cua phan du (residual)
# 4. R binh phuong & R binh phuong sau hieu chinh
# 5. F-statistic & p_value

# 5 thong tin tren dung de danh gia mo hinh co phu hop vs thuc te khong

# Tim xem cau truc du lieu cua lm.fit vua build
names(lm.fit)

# In ra he so cua mo hinh lm.fit 
coef(lm.fit)

# Tim khoang tin cay cua cac he so cua mo hinh
confint(lm.fit)   #Default is khoang (2.5% den 95.5%) <=> level = 0.95
confint(lm.fit, level = 0.99)   #(0.5% den 99.5%)

# Hàm dự đoán () có thể được sử dụng để tạo khoảng tin cậy và dự đoán medv cho một giá trị nhất định của lstat.
# Du doan gia tri cu the va khoang tin cay cho ""gia tri trung binh ""
#cua medv khi biet gia tri
#cua lstat dua vao mo hinh hoi quy da cho
predict(lm.fit, data.frame(lstat=(c(0,10,10))), 
        interval="confidence")    #Default is khoang tin cay 95%

# Du doan gia tri cu the va khoang tin cay cho ""gia tri thuc""
#cua medv khi biet gia tri
#cua lstat dua vao mo hinh hoi quy da cho
predict(lm.fit, data.frame(lstat=(c(0,10,10))),
        interval ="prediction")   #Default is khoang tin cay 95%
?predict

# Ve do thi dam may diem & duong thang hoi quy
plot(lstat, medv)   #Ve dam may diem
abline(lm.fit)      #Ve duong thang hoi quy

# Mot so to diem cho do thi dep hon
abline (lm.fit ,lwd =3)
abline (lm.fit ,lwd=3,col ="red")
plot(lstat ,medv ,col="red")
plot(lstat ,medv ,pch =20)
plot(lstat ,medv ,pch ="+")
plot(1:20,1:20,pch =1:20)

# Cai dat giao dien ve nhieu do thi
par(mfrow=c(3,2))
plot(lm.fit)

# Ve ket qua du doan theo phan du & pp student
plot(predict (lm.fit), residuals (lm.fit))
plot(predict (lm.fit), rstudent (lm.fit))

# Ve ket qua cua hatvalues
plot(hatvalues (lm.fit))

# Tra ve gia tri index cua phan tu la max cua vector hatvalues
which.max(hatvalues (lm.fit))


# CAC BAI TOAN
# 1. Kiem dinh sai so e co theo phan phoi chuan hay khong?
# 2. Neu sai so e co theo phan phoi chuan thi gia tri trung binh E[e] co bang 0 hay khong?
e = lm.fit$residuals
shapiro.test(e) 
t.test(e, mu = 0) #neu e tuan theo pp chuan

# 3. Kiem dinh xem cac he so co bang 0 hay khong?
# 3.1. Kiem dinh b0 = 0 hay khong
lm.fit1 = lm(medv ~ lstat + 0) #co +0 de khong in ra he so = 0
lm.fit1
# 3.2. Kiem dinh b1 = 0 hay khong (neu bang 0 thi xay dung mo hinh khong co y nghia)
