package com.cac.Homebanking3.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {



        private Long id;
        private Long origin;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getOrigin() {
                return origin;
        }

        public void setOrigin(Long origin) {
                this.origin = origin;
        }

        public Long getTarget() {
                return target;
        }

        public void setTarget(Long target) {
                this.target = target;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public BigDecimal getAmount() {
                return amount;
        }

        public void setAmount(BigDecimal amount) {
                this.amount = amount;
        }

        private Long target;
        private Date date;
        private BigDecimal amount;

    }


