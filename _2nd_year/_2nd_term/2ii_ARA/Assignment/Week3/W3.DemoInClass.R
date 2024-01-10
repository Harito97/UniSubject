# CAC BUOC HUAN LUYEN 1 MO HINH HOI QUY TUYEN TINH & KIEM TRA SU PHU HOP CUA MO HINH DO
# ******************************************************************************
#
# Step 1. Chia bo du lieu thanh 2 phan: training data set & test data set
# Trong R: Chon ngau nhien 1 phan cua bo du lieu de lam training data (thg theo ty le cho truoc)
# Phan con lai dung lam test data

# Step 2. Tren training data:
# Thuc hien phan tich hoi quy tuyen tinh Y = a_0 + a_1 * X + e
# va dua ra mo hinh Y = a_0_h + a_1_h * X 
# Dua ra khoang tin cay beta cho a_0 & a_1
# Danh gia he so cua mo hinh (H0: cof = 0 | H1: cof != 0)
# => Dua ra duoc R va uoc luong he so hoi quy a_0_h & a_1_h

# Step 3. Tren test data:
# Tinh TSS = sum( (y - mean(y))^2 )                           - Xet tren y
# Tinh RSS = sum( (y - a_0_h - a_1_h * x)^2 ) = sum( e^2 )    - Xet tren phan du

# Tinh R^2 = 1 - RSS/TSS 
# voi R = sqrt(R^2) la he so tuong quan mau: do muc do phu thuoc tuyen tinh cua Y vao X
# R^2 thuoc [0, 1]
# R square la he so xem Y co phu hop voi X. R square cang lon thi mo hinh cang hop ly

# ******************************************************************************
# install.packages("datasets")
library(datasets)
data = data(iris)
? iris
names(iris)
set.seed(1)   #co dinh data de khi chay ham sample, nrow, ... thi data khong thay doi ngau nhien sau cac lan
View(iris)
# Use 70% of dataset as training set and remaining 30% as testing set
sample = sample(c(TRUE, FALSE), nrow(iris), replace = TRUE, prob = c(0.7, 0.3))
? sample
table(sample)   # Biet ty le cua tap false & true

# Step1.
# Chia tap data
train = subset(iris, sample == TRUE)
test = subset(iris, sample == FALSE)
train = iris[sample,]
test = iris[!sample,]
dim(train)
dim(test)
# Sau Step1. Bo du lieu iris gom 150 quan sat duoc chia lam 2 bo du lieu con: training 106 qsat & testing 44 qsat

# Step2.
# Viet mo hinh hoi quy tuyen tinh cua Sepal.Length theo Petal.Length
attach(iris)
lmSe_Pe = lm(train$Sepal.Length ~ train$Petal.Length)
lmSe_Pe
summary(lmSe_Pe)  #Summary de danh gia he so
confint(lmSe_Pe, level = 0.9)  #Khoang tin cay 95% cho cac he so
# Danh gia he mo cua mo hinh
# H0: a_0 = 0 | H1 a_0 != 0
# p-value: < 2.2e-16 < 0.05 -> Bac bo H0: 
# KL: Vay voi myn = 5% thi co co so a_0 != 0

# H0: a_1 = 0 | H1: a_1 != 0
# p-value: < 2.2e-16 < 0.05 -> Bac bo H0: 
# KL: Vay voi myn = 5% thi co co so a_1 != 0

# Dua ra R-squared = 0.7781
# Uoc luong he so hoi quy la
# Coefficients:
# Estimate  
# (Intercept)         4.23794   = a_0_h
# train$Petal.Length  0.42855   = a_1_h

# Step3.
# Mo hinh hoi quy la:
Y_predict = lmSe_Pe$coefficients[1] + lmSe_Pe$coefficients[2] * test$Petal.Length
#Y_mean_predict = mean(Y_predict)
#TSS = sum((test$Sepal.Length - Y_mean_predict)^2)
TSS = sum((test$Sepal.Length - mean(test$Sepal.Length))^2)
TSS
RSS = sum((test$Sepal.Length - Y_predict)^2)
RSS
R2 = 1 - RSS/TSS
R2
sqrt(R2)

