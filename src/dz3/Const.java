package dz3;

public final class Const {
	final static int CARFARE = 1000; 			// Стоимость проезда легкового автомобиля
	final static int TRUCKFARE = 2000;			// Стоимость проезда грузовика
	final static int WITHTRAILER = 500;			// Добавочная оплата при наличии прицепа
	final static int EXCESSCAPACITYCOST = 800;	// Добавочная оплата за превышение веса
	
	final static int SPEEDLIMIT1 = 0;			// Первый лимит скорости
	final static int SPEEDPENALTY1 = 500;		// Штраф за превышение первого лимита
	final static int SPEEDLIMIT2 = 20;			// ...
	final static int SPEEDPENALTY2 = 1500;		// ...
	final static int SPEEDLIMIT3 = 40;			// ...
	final static int SPEEDPENALTY3 = 2500;		// ...
	final static int SPEEDLIMIT4 = 60;			// ...
	final static int SPEEDPENALTY4 = 5000;		// ...
	
	final static int MAXHEIGHT = 400;			// Максимальная высота
	final static int MAXCAPACITY = 10000;		// Максимальный вес
	final static int MAXSPEEDSOFT = 80;			// Максимальная скорость при которой накладываются штрафы
	final static int MAXSPEEDHARD = 180;		// Максимальная скорость при которой вызывается патруль ГИБДД
}
