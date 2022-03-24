package fi.experis.mefit.controllers;

import fi.experis.mefit.models.dtos.goalDto.GoalDTO;
import fi.experis.mefit.models.entities.Goal;
import fi.experis.mefit.services.interfaces.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Get goal by id")
    @GetMapping("/{goalId}")
    public ResponseEntity<GoalDTO> getGoalById(@Parameter(description = "Id of goal to be searched") @PathVariable Long goalId) {
        return goalService.getGoalById(goalId);
    }

    @Operation(summary = "Create a new goal")
    @PostMapping
    public ResponseEntity<String> addGoal(@RequestBody GoalDTO goal) {
        return goalService.addGoal(goal);
    }

    @Operation(summary = "Update goal by id")
    @PatchMapping("/{goalId}")
    public ResponseEntity<String> updateGoal(@Parameter(description = "Id of goal to be updated") @PathVariable Long goalId, @RequestBody GoalDTO goal) {
        return goalService.updateGoal(goalId, goal);
    }

    @Operation(summary = "Delete goal by id")
    @DeleteMapping("/{goalId}")
    public ResponseEntity<String> deleteGoal(@Parameter(description = "Id of goal to be deleted")@PathVariable Long goalId) {
        return goalService.deleteGoalById(goalId);
    }
}
