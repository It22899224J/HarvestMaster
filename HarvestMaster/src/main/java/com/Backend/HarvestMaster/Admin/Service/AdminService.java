package com.Backend.HarvestMaster.Admin.Service;

import com.Backend.HarvestMaster.Admin.Model.Admin;

public interface AdminService {
    Admin getAdminByEmail(String email);
}
