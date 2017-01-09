#include "pwm.h"
#include "key.h"

int main(int argc, const char *argv[])
{
	int temp; 

	key_init();
	pwm_init();

	while(1)
	{
		if((temp = key_read()) > 0)
		{
			switch(temp)
			{
				case 1:
					pwm_setfre(100);
					beep_on();
					usleep(100000);
					beep_off();
					break;
				case 2:
					pwm_setfre(200);
					beep_on();
					usleep(100000);
					beep_off();
					break;
				case 3:
					pwm_setfre(300);
					beep_on();
					usleep(100000);
					beep_off();
					break;
				case 4:
					pwm_setfre(400);
					beep_on();
					usleep(100000);
					beep_off();
					break;
			}
		}
		
	}
	pwm_exit();
	key_exit();
	return 0;
}

