package com.zbs.eventbus;

public interface BusinessEventBus {
	
	//¸øevent×¢²á¼àÌıÊÂ¼ş
	void register(Object object);

    void post(BaseEvent event);

}
