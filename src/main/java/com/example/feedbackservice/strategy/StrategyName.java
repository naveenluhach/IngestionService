package com.example.feedbackservice.strategy;

public enum StrategyName {
        TWITTER("twitter"),
        GOOGLE("google"),
        DISCOURSE("discourse");

        private final String text;

        /**
         * @param text
         */
        StrategyName(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }
