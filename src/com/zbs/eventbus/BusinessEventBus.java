package com.zbs.eventbus;

public interface BusinessEventBus {
	
	//��eventע������¼�
	void register(Object object);

    void post(BaseEvent event);

}
