package com.company.service;

import com.company.interfaces.Resettable;
import com.company.interfaces.WorkingWithAnimals;

public interface Service extends Resettable, WorkingWithAnimals {

    boolean isEnd(boolean route);

}
