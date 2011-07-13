package net.slowvic.lang.enumeration;

public class Enum02
{
	public static void main(String[] args)
	{
		PayRollDay prd = PayRollDay.MONDAY;
		System.out.printf("%s工作%s小时，计工资%f",prd.name(),9,prd.pay(9,20));
	}
}

enum PayRollDay
{
	MONDAY(PayType.WEEKDAY),TUESDAY(PayType.WEEKDAY),WEDNESDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),FRIDAY(PayType.WEEKDAY),
	STATURDAY(PayType.WEEKEND),SUNDAY(PayType.WEEKEND);
	
	private final PayType payType;
	
	private PayRollDay(PayType payType)
	{
		this.payType = payType;
	}
	
	double pay(double hoursWorked,double rate)
	{
		return payType.pay(hoursWorked,rate);
	}
	
	enum PayType
	{
		WEEKDAY
		{
			double overtimePay(double hrs,double rate)
			{
				return hrs<HOURS_PER_SHIFT ? 0 : (hrs-HOURS_PER_SHIFT) * rate / 2;
			}
		}
		,
		WEEKEND
		{
			double overtimePay(double hrs,double rate)
			{
				return hrs * rate ;
			}
		};
		
		private static final int HOURS_PER_SHIFT = 8;
		
		abstract double overtimePay(double hrs,double rate);
		
		double pay(double hoursWorked,double rate)
		{
			double basePay = hoursWorked * rate;
			return basePay + overtimePay(hoursWorked,rate);
		}
	}
}