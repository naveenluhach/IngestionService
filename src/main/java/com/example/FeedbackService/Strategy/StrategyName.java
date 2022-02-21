package com.example.FeedbackService.Strategy;

public enum StrategyName {
        TWITTER("TWITTER"),
        GOOGLE("GOOGLE"),
        DISCOURSE("DISCOURSE");

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
