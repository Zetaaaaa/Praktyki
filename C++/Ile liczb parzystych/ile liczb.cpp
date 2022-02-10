#include <iostream>

using namespace std;

int iloscLiczb = 30;


int main() {
	
	
int i = 0;
int j = 0;
int tablicaliczb[iloscLiczb];
int okreslenieTablicy;
  
// liczby uzytkownika

cout << "Podaj liczby " << iloscLiczb << endl;
  
 while(i < iloscLiczb) 
{
;
cin >> okreslenieTablicy;
tablicaliczb[i] = okreslenieTablicy;
i ++;
}
  
  
  
// jesli obiekt z tablicy podzielony przez 2 daje resztê 0 to zwiêksz zmienn¹ parzyste
int Parzyste = 0;
i = 0;
while(i < iloscLiczb) 
{
if(tablicaliczb[i] % 2 == 0) Parzyste ++;
i ++;
}

//odpowiedŸ
cout <<"Ilosc podanych liczb parzystych : " << Parzyste << endl;


//Suma liczb podzielnych przez 5

int Podzielne5 = 0;

do
{
if(tablicaliczb[j] % 5 == 0) Podzielne5 += tablicaliczb[j];
j ++;
}
while(j < iloscLiczb);
 
cout <<"Suma liczb podzielnych przez 5 wynosi "<< Podzielne5<< endl;

//liczby podzielne przez 3 albo 5

cout <<"Liczby podzielne przez 3 albo 5" << endl;
for(int i = 0; i < iloscLiczb; i ++) 
if((tablicaliczb[i] % 3 == 0 && tablicaliczb[i] % 5 != 0) || (tablicaliczb[i] % 3 != 0 && tablicaliczb[i] % 5 == 0)) 
{

cout << tablicaliczb[i] << endl;
}

}

