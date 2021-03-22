def acceptMatrix(matrix, rows, columns):

    print("Enter Elements : ")
    for _ in range(rows):
        temp_column = []
        for _ in range(columns):
            temp_column.append(int(input()))
        matrix.append(temp_column)


def addMatrix():
    if(matrix_i.__len__() != matrix_ii.__len__()):
        print("Cannot add matrix as Number of Elements does not match")
        return

    temp_matrix = []
    for i in range(matrix_i.__len__()):
        temp_column = []
        for j in range(matrix_ii.__len__()):
            temp_column.append(matrix_i[i][j]+matrix_ii[i][j])
        temp_matrix.append(temp_column)
    displayMatrix(temp_matrix)


def subtractMatrix():
    if(matrix_i.__len__() != matrix_ii.__len__()):
        print("Cannot subtract matrix as Number of Elements does not match")
        return

    temp_matrix = []
    for i in range(matrix_i.__len__()):
        temp_column = []
        for j in range(matrix_ii.__len__()):
            temp_column.append(matrix_i[i][j] - matrix_ii[i][j])
        temp_matrix.append(temp_column)
    displayMatrix(temp_matrix)


def multiplyMatrix():
    if(no_of_row_i != no_of_col_ii | no_of_row_ii != no_of_col_i):
        print("Cannot multiply matrix as it violates matrix multiplication rules")
        return

    temp_matrix = []
    for i in range(matrix_i.__len__()):
        temp_column = []
        for j in range(matrix_ii.__len__()):
            temp_column.append(matrix_i[i][j]*matrix_ii[j][i])
        temp_matrix.append(temp_column)
    displayMatrix(temp_matrix)


def displayMatrix(matrix):

    rows = matrix.__len__()
    columns = matrix[0].__len__()
    for i in range(rows):
        for j in range(columns):
            print(matrix[i][j], end=" ")
        print()
    print()


def transpose(matrix):

    transpose_maxtrix = []
    rows = matrix.__len__()
    columns = matrix[0].__len__()

    for i in range(rows):
        temp = []
        for j in range(columns):
            temp.append(matrix[j][i])
        transpose_maxtrix.append(temp)
    return transpose_maxtrix


def chksymmetric(matrix, transpose):
    rows = matrix.__len__()
    columns = matrix[0].__len__()

    if(rows != columns):
        return False

    for i in range(rows):
        for j in range(columns):
            if(matrix[i][j] != transpose[i][j]):
                return False

    return True


def isBinaryMatrix(matrix):
    rows = matrix.__len__()
    columns = matrix[0].__len__()
    for i in range(rows):
        for j in range(columns):
            if ((matrix[i][j] != 0 and matrix[i][j] != 1)):
                return False
    return True


matrix_i = []
print("For Matrix I : ")
no_of_row_i = int(input("Enter No of Rows : "))
no_of_col_i = int(input("Enter No of Columns : "))
acceptMatrix(matrix_i, no_of_row_i, no_of_col_i)
displayMatrix(matrix_i)


matrix_ii = []
print("For Matrix I : ")
no_of_row_ii = int(input("Enter No of Rows : "))
no_of_col_ii = int(input("Enter No of Columns : "))
acceptMatrix(matrix_ii, no_of_row_ii, no_of_col_ii)
displayMatrix(matrix_ii)

transpose_maxtrix_i = transpose(matrix_i)
print("Transpose of Matrix II :")
displayMatrix(transpose_maxtrix_i)


transpose_maxtrix_ii = transpose(matrix_ii)
print("Transpose of Matrix II : ")
displayMatrix(transpose_maxtrix_ii)


print(
    f"is Matrix I Symmetric : {chksymmetric(matrix_i, transpose_maxtrix_i)}")
print(
    f"is Matrix I Symmetric : {chksymmetric(matrix_ii, transpose_maxtrix_ii)}")

print(
    f"is Matrix Binary: {isBinaryMatrix(matrix_i)}")
print(
    f"is Matrix Binary: {isBinaryMatrix(matrix_ii)}")

print("Addition of Both Matrix : ")
addMatrix()

print("Subtraction of Both Matrix : ")
subtractMatrix()

print("Multiplication of Both Matrix : ")
multiplyMatrix()
