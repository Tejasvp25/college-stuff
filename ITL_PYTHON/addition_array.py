"""
Name - Tejas Patil
GR No - xxxxxxxx
Roll No - xxxxxx
Div - SY-C

https://github.com/Tejasvp25/college-stuff/blob/master/ITL_PYTHON/addition_array.py

"""
original_array = []


# Get length of Array
number_of_elements = int(input("Enter Number of Elements in Array : "))

# Get elements of First Array
print("Enter Elements for First Array")
for i in range(0, number_of_elements):
    original_array.append(int(input(f"Enter Element No {i} : ")))

# Reverse Array using sliceing method ( list.reverse() returning None )
reversed_array = original_array[::-1]

addition_of_array_elements = []

i = 0
# Add ith element of both array and append it to addition_of_array_elements
while i < number_of_elements:
    addition_of_array_elements.append(original_array[i]+reversed_array[i])
    i += 1

print(f"Addition of Both Array : {addition_of_array_elements}")
