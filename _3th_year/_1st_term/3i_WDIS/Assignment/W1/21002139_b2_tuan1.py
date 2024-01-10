def check_math_term(term):
    return term[:3] == 'MAT'

print(check_math_term('MAT3385'))
print(check_math_term('GEO2060'))
print(check_math_term('EVS2305'))