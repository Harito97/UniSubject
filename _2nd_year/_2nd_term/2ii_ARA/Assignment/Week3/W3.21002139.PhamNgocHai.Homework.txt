library(datasets)
data(cars)
View(cars)
set.seed(9)   #co dinh data de khi chay ham sample, nrow, ... thi data khong thay doi ngau nhien sau cac lan

# Bài 1. Chia bộ dữ liệu cars thành hai bộ dữ liệu con: training (65%) và testing (35%)
# Step1.
# Use 65% of dataset as training set and remaining 35% as testing set
sample = sample(c(TRUE, FALSE), nrow(cars), replace = TRUE, prob = c(0.65, 0.35))
train = cars[sample,]
test = cars[!sample,]
dim(train)
dim(test)
table(sample)
# sample
# FALSE  TRUE 
# 19    31 

# Bài 2. Phân tích hồi quy tuyến tính của biến dist theo speed  trên bộ dữ liệu training.
# Step2.
lmDis_Speed = lm(cars$dist ~ cars$speed)
lmDis_Speed
summary(lmDis_Speed)
confint(lmDis_Speed)
# Khoang tin cay 95% cho cac he so
#                  2.5 %    97.5 %
# (Intercept) -31.167850 -3.990340
# cars$speed    3.096964  4.767853

# Danh gia he mo cua mo hinh
# H0: a_0 = 0 | H1 a_0 != 0
# p-value: < 0.0123 < 0.05 -> Bac bo H0: 
# KL: Vay voi myn = 5% thi a_0 != 0

# H0: a_1 = 0 | H1: a_1 != 0
# p-value: < 1.49e-12 < 0.05 -> Bac bo H0: 
# KL: Vay voi myn = 5% thi a_1 != 0

# Dua ra R-squared = 0.6511

# Uoc luong he so hoi quy la
# Coefficients:
#             Estimate   
# (Intercept) -17.5791    = a_0_h
# cars$speed    3.9324    = a_1_h

# Bài 3. Đánh giá trên bộ dữ liệu testing.
# Step3.
dist_predict = lmDis_Speed$coefficients[1] + lmDis_Speed$coefficients[2] * test$speed

TSS = sum((test$dist - mean(test$dist))^2)
TSS
RSS = sum((test$dist - dist_predict)^2)
RSS
R2 = 1 - RSS/TSS
R2
sqrt(R2)
# > R2
# [1] 0.6783608
# > sqrt(R2)
# [1] 0.8236266 = R => có thể chấp nhận mô hình hồi quy tuyến tính này