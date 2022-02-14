#include <iostream>
using namespace std;

int liczba;
int temp;
int temp2;
float sort[5];

void sortowanko1()
{

    for (int a = 0; a < 4; a++)
    {

        for (int n = 0; n < 4; n++)
        {

            if (sort[n] > sort[n + 1])
            {

                temp = sort[n];
                temp2 = sort[n + 1];
                sort[n] = temp2;
                sort[n + 1] = temp;
            }
        }
    }
}



void sortowanko2()
{
	
	
	
	
	
}

int main()
{

    cout << "Sortowanie wsteczne 5 liczb" << endl;

    for (int j = 0; j < 5; j++)
    {

        cout << "Podaj " << j + 1 << " liczbe: " << endl;
        cin >> sort[j];

        cout << j << ": " << sort[j] << endl;
    }

    sortowanko1();

    cout << "Posortowane !" << endl;

    for (int k = 0; k < 5; k++)
    {

        cout << sort[k] << ", ";
    }
}

