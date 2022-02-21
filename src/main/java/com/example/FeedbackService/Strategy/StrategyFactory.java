package com.example.FeedbackService.Strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StrategyFactory {
        private Map<String, Strategy> strategies;

        @Autowired
        public StrategyFactory(Set<Strategy> strategySet) {
            createStrategy(strategySet);
        }

        public Strategy findStrategy(String strategyName) {
            return strategies.get(strategyName);
        }
        private void createStrategy(Set<Strategy> strategySet) {
            strategies = new HashMap<String, Strategy>();
            strategySet.forEach(
                    strategy ->strategies.put(strategy.getStrategyName(), strategy));
        }
    }
