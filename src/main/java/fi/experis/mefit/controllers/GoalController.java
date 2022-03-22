package fi.experis.mefit.controllers;

import fi.experis.mefit.models.entities.Goal;
import fi.experis.mefit.services.interfaces.GoalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/goals")
@SecurityRequirement(name = "keycloak_implicit")
@PreAuthorize("hasAnyRole('ROLE_regular-user', 'ROLE_contributor', 'ROLE_admin')")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long goalId) {
        return goalService.getGoalById(goalId);
    }

    @PostMapping
    public ResponseEntity<String> addGoal(@RequestBody Goal goal) {
        return goalService.addGoal(goal);
    }

    @PatchMapping("/{goalId}")
    public ResponseEntity<String> updateGoal(@PathVariable Long goalId, @RequestBody Map<Object, Object> fields) {
        return goalService.updateGoal(goalId, fields);
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<String> deleteGoal(@PathVariable Long goalId) {
        return goalService.deleteGoalById(goalId);
    }
}
