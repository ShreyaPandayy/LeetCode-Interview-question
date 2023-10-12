# Python3 code to demonstrate
# to perform element duplication
# using list comprehension

# initializing list
test_list = [4, 5, 6, 3, 9]

# printing original list
print("The original list is : " + str(test_list))

# using list comprehension
# to perform element duplication
res = [i for i in test_list for x in (0, 1)]

# printing result
print("The list after element duplication " + str(res))
