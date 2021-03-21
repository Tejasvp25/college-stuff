/*
    GR No. -> xxxxxxxx
    Roll No. -> xxxxxx
    Name  ->  Tejas Vijay Patil
    Div -> xxxx
*/

#include <iostream>
using namespace std;

struct Student
{
    int roll_no, marks;
    string name;
};

int main()
{
    struct Student std[10];
    for (int i = 0; i < 10; i++)
    {
        std::cout << "Enter roll no of Student : " << std::endl;
        std::cin >> std[i].roll_no;
        std::cout << "Enter Name of Student : " << std::endl;
        std::cin >> std[i].name;
        std::cout << "Enter Marks of Student : " << std::endl;
        std::cin >> std[i].marks;
        std::cout << std::endl;
    }

    for (int i = 0; i < 10; i++)
    {
        std::cout << "Name of Student : " << std[i].name << std::endl;
        std::cout << "Roll No of Student : " << std[i].roll_no << std::endl;
        std::cout << "Marks of Student : " << std[i].marks << std::endl;
        std::cout << std::endl;
    }
}
