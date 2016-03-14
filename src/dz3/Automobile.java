package dz3;

public abstract class Automobile {
	public int width = 0;
	public int length = 0;
	public int height = 0;
	
	public int speed = 0;
	public int capacity = 0;	
	
	public boolean isSpecial = false;
	public boolean haveTrailer = false;
	
	public String fareInfo = "";
	
	/*
	 * Проверка на превышение скорости
	 */
	public int checkSpeedPenalty() throws ExceededMaxSpeedException {
		int diff;
		
		if (this.speed >= Const.MAXSPEEDHARD) {
			throw new ExceededMaxSpeedException();
		}

		// ВОПРОС:
		// Можно ли как-нить использовать строку вместо имени константы?
		// т.е. чтобы было "SPEEDLIMIT"+i
		
		if (this.speed > Const.MAXSPEEDSOFT) {		
			diff = this.speed - Const.MAXSPEEDSOFT;
			if (diff >= Const.SPEEDLIMIT4) {
				return Const.SPEEDPENALTY4;
			} else if (diff >= Const.SPEEDLIMIT3) {
				return Const.SPEEDPENALTY3;
			} else if (diff >= Const.SPEEDLIMIT2) {
				return Const.SPEEDPENALTY2;
			} else if (diff >= Const.SPEEDLIMIT1) {
				return Const.SPEEDPENALTY1;						
			}
		}

		return 0;
	}	
	
	/*
	 * Проверка на превышение допустимых размеров
	 */
	public int checkSizeLimits() throws ExceededMaxHeightException {
		if(this.height > Const.MAXHEIGHT) {
			throw new ExceededMaxHeightException();
		}
		
		return 0;
	}
	
	/*
	 * Расчет стоимости проезда
	 */
	public abstract int getFare() throws ExceededMaxSpeedException, ExceededMaxHeightException;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		String spec = this.isSpecial ? "Да" : "Нет";
		String trailer = this.haveTrailer ? "Есть" : "Нет";
	
		return this.getClass().getName() + ":\n" +
			String.format(
				"Размеры (ШхДхВ): %s x %s x %s,\n" +
				"Скорость: %s,\n" +
				"Грузоподъемность: %s,\n" +
				"Cпец. транспорт: %s,\n" +
				"Прицеп: %s\n----------\n", 
				this.width, 
				this.length, 
				this.height,
				this.speed,
				this.capacity,
				spec,
				trailer
				);
		
	}
}
