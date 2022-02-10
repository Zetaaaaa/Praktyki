#include <iostream>

using namespace std;

// wypisuje liczby od 1 do 30
// liczby podzielne przez 3 zastepuje slowem 'ABC'
// liczby podzielne przez 5, zastepuje slowem 'DEF'
// liczby podzielne przez 3 i przez 5 zastepuje slowem 'ABCDEF'


void print1to() {
	 cout << "" << endl;
	 cout << "Liczby podzielne tylko przez 3 - ABC" << endl;
	 cout << "Liczby podzielne tylko przez 5 - DEF " << endl;
	 cout << "Liczby podzielne przez 3 i 5 - ABCDEF " << endl;
	 cout <<  "Liczby od 1 do 30" << endl << endl;
	 
  for(int i = 1; i <= 30; i ++) {
    if(i % 3 == 0 && i % 5 == 0) cout << "ABCDEF ";
    else if(i % 3 == 0) cout << "ABC ";
    else if(i % 5 == 0) cout << "DEF ";
    else cout << i << " ";
  }
}

// NWD
int gcd(int c, int d) {
  do {
      if ( c > d ) c = c % d;
      else if ( c < d ) d = d % c;
      else if ( c == d ) break;
  } while (c != 0 && d != 0);

  return max(c, d);
}

int main() {

  print1to();
  cout << endl;

  int a, b;
  
  cout << "Podaj pierwsza liczbe : ";
  cin >> a;
  cout << "Podaj druga liczbe : ";
  cin >> b;
  cout <<"Najwiekszy wspolny dzielnik tych liczb wynosi : "<< gcd(a, b);

  return 0;
  

}
