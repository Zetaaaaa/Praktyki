#include <iostream>
#include <cstdio>
#include <time.h>
#include <windows.h>


using namespace std;
//zmienne
int metoda;
int liczbygracza[6];
int winum[6];




int main() 
{

Wybor:
	system("cls");
	setlocale(LC_CTYPE, "Polish");
	cout<<"################  Gra liczbowa AlaLOTTO ################"<<endl;
	

		
	cout<<endl;
	cout<<"Wybierz tryb gry:"<<endl;
	cout<<endl;
	cout<<"1. Program automatycznie wybiera liczby dla gracza"<<endl;
	cout<<"2. Gracz wybiera 6 liczb"<<endl;
	cout<<"3. Zatrzymaj program"<<endl;
	
	// Wybor metody
	cout<<"Wybieram: ";
	cin>>metoda;
	
	// 
	srand(time(NULL));
	
	// 1 tryb gry
				
	if(metoda==1){
		system("cls");
		cout<<"############### TRYB GRY: Program automatycznie wybiera liczby dla gracza ###############";
		cout<<""<<endl;
		
		for(int i=0;i<6;i++){
				los1:
			int	r = (rand() % 49) + 1;
			
			for(int j=0;j<6;j++){
				if(r==winum[j]){
					goto los1;
				}
			
			}
			winum[i] = r;
		}
					
		for(int i=0;i<6;i++){
				los:
			int	r = (rand() % 49) + 1;
			
			for(int j=0;j<6;j++){
				if(r==liczbygracza[j]){
					goto los;
				}
			
			}
			
			liczbygracza[i] = r;
		}
		
	}
		
	else if(metoda==2) {
			
			for(int k=0;k<6;k++){
				cout<<"Wpisz "<<k+1<<" liczbe ";
				los12:
				int g;
				cin>>g;
				for(int j=0;j<6;j++){
					if(g==liczbygracza[j]){
						cout<<"Liczby nie mog¹ siê powtarzaæ! Wpisz inn¹: ";
						goto los12;
					}
					else if(g<1 || g>49){
							cout<<"Liczby nie mo¿e byæ mniejsza ni¿ 1 i wiêksza ni¿ 49! Wpisz inn¹: ";
						goto los12;	
					}
					
				}		
				liczbygracza[k] = g;
			}
		}
		
		Liczenie:
			int punkty = 0;
			
			for(int i=0;i<6;i++){
				for(int j=0;j<6;j++){
					if(liczbygracza[i] == winum[j])
					punkty++;
				}
			
			}
		

		
		
		
		//Wygrana
		//	cout<<"Ilosc punktow: "<<punkty<<endl;
			system("cls");
			
			cout<<"################  Wynik  ################"<<endl<<endl;
			
		
		
		if(punkty==0 || punkty==1 || punkty==2) cout<<"Niestety tym razem nic nie wygrales"<<endl<<endl; 
	
		else if(punkty==3) cout<<"Gratulacje wygrana IV stopnia ! (3 liczby wytypowane poprawnie)"<<endl<<endl;  
				
		else if(punkty==4) cout<<"Gratulacje wygrana III stopnia ! (4 liczby wytypowane poprawnie)"<<endl<<endl; 

		else if(punkty==5) cout<<"Gratulacje wygrana II stopnia ! (5 liczby wytypowane poprawnie)"<<endl<<endl; 
			
		else if(punkty==6) cout<<"Gratulacje wygrana IV stopnia ! (3 liczby wytypowane poprawnie)"<<endl<<endl; 
	

		
		Koniec:		
		cout<<"Poprawne liczby : "<<punkty<<endl<<endl;
		cout<<"Czy chcesz graæ dalej?"<<endl;
		cout<<endl;
		cout<<"1. Tak (powrót do g³ównego menu)"<<endl;
		cout<<"2. Nie (wy³¹cza program)"<<endl;
		
		int wybor;
		cin>>wybor;
		if(wybor==1){
			goto Wybor;
		}
		else if(wybor==2){
			return 0;
		}
		else{
			cout<<"Nie ma takiego wyboru"<<endl;
			cout<<endl;
			goto Koniec;
		}
		

}


		
