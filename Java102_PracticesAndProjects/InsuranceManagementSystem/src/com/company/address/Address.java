package com.company.address;

import com.company.user.User;

public interface Address<T extends Address> {
    void showAddressInfo();
}
