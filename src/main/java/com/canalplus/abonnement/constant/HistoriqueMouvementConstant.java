package com.canalplus.abonnement.constant;

public class HistoriqueMouvementConstant {
    public enum Type {
        CREATION("CREATION"),
        MODIFICATION("MODIFICATION");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return  this.type;
        }
    }
}
