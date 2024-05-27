package com.example.restaurant.Service;


import com.example.restaurant.Model.MovementStock;
import com.example.restaurant.Model.ShowMovementStock;
import com.example.restaurant.Repository.CrudOperationsMovement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class MovementService {
    private CrudOperationsMovement repository;

    public List<MovementStock> findAll() throws SQLException{
        return repository.findAll();
    }

    public MovementStock save(MovementStock toSave) throws SQLException{
        if (toSave.getMovementDate() == null) {
            toSave.setMovementDate(Instant.now());
        }
        return repository.save(toSave);
    }

    public MovementStock update(int id, MovementStock toUpdate) throws  SQLException{
        return repository.update(id,toUpdate);
    }

    public List<ShowMovementStock> showAll(Instant startDate, Instant endDate) throws SQLException{
        return repository.showMovementStock(startDate,endDate);
    }
}
