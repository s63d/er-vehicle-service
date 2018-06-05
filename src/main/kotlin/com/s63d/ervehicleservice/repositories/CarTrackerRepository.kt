package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.db.CarTracker
import org.springframework.data.repository.CrudRepository

interface CarTrackerRepository : CrudRepository<CarTracker, String>