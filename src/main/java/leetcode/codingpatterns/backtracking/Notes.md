**Key Indicators:**

- The problem involves exploring multiple possibilities incrementally.
- There are decision points or constraints that necessitate trying out different options.
- You need to find all possible solutions or satisfy specific conditions through an exhaustive search.

⚙️ General Template (Java)

    void backtrack(State currentState, List<State> results) {
    if (baseCaseReached(currentState)) {
    results.add(copy(currentState));
    return;
    }
    
        for (Choice choice : allChoices) {
            if (!isValid(choice)) continue;  // optional pruning
            makeChoice(currentState, choice);
            backtrack(currentState, results);
            undoChoice(currentState, choice); // backtrack
        }
    }