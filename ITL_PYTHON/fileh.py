
file = open("user_details.txt", "a+")

for _ in range(10):
    age = input("Enter your Age : ")
    name = input("Enter your name : ")
    file.writelines([age+"\n", name + "\n"])
    print()
file.close()


file = open("user_details.txt", "r")
for _ in range(10):
    age = file.readline().replace("\n", " ", -1)
    name = file.readline().replace("\n", " ", -1)
    print(f"Age : {age}")
    print(f"Name : {name}")
    print()

file.close()
