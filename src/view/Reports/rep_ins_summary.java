/*
 * rep_ins_summary.java
 *
 * Created on May 11, 2011, 11:23 PM
 */

package view.Reports;

import control.rep_ins_summaryControl;

/**
 *
 * @author  gihan
 */
public final class rep_ins_summary extends javax.swing.JPanel {
rep_ins_summaryControl institutesum = new rep_ins_summaryControl();
    /** Creates new form rep_ins_summary */
    public rep_ins_summary() {
        initComponents();
        institutesum.loadsummery(totalregstudents, totalactiveStudents, totalinactive, totalteachers, totalactiveteachrs, totalinactiveteach, totalactiveclasses);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        totalregstudents = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        totalactiveStudents = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        totalinactive = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        totalinactiveteach = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        totalactiveteachrs = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        totalteachers = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        totalactiveclasses = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(153, 180, 209));

        jPanel1.setBackground(new java.awt.Color(191, 205, 219));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel25.setForeground(new java.awt.Color(98, 95, 95));
        jLabel25.setText("Total Registered Students");

        totalregstudents.setFont(new java.awt.Font("Dialog", 3, 14));
        totalregstudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalregstudents.setText("0000");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel26.setForeground(new java.awt.Color(98, 95, 95));
        jLabel26.setText("Total of Active Students:");

        totalactiveStudents.setFont(new java.awt.Font("Dialog", 3, 14));
        totalactiveStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalactiveStudents.setText("0000");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel30.setForeground(new java.awt.Color(98, 95, 95));
        jLabel30.setText("Inactive Students:");

        totalinactive.setFont(new java.awt.Font("Dialog", 3, 14));
        totalinactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalinactive.setText("0000");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel32.setForeground(new java.awt.Color(98, 95, 95));
        jLabel32.setText("Inactive Teachers:");

        totalinactiveteach.setFont(new java.awt.Font("Dialog", 3, 14));
        totalinactiveteach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalinactiveteach.setText("0000");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel28.setForeground(new java.awt.Color(98, 95, 95));
        jLabel28.setText("Active Teachers:");

        totalactiveteachrs.setFont(new java.awt.Font("Dialog", 3, 14));
        totalactiveteachrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalactiveteachrs.setText("0000");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel27.setForeground(new java.awt.Color(98, 95, 95));
        jLabel27.setText("Total Registered Teachers:");

        totalteachers.setFont(new java.awt.Font("Dialog", 3, 14));
        totalteachers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalteachers.setText("0000");

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel31.setForeground(new java.awt.Color(98, 95, 95));
        jLabel31.setText("Total Classes:");

        totalactiveclasses.setFont(new java.awt.Font("Dialog", 3, 14));
        totalactiveclasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalactiveclasses.setText("0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalregstudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalactiveStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalinactive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalteachers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalactiveteachrs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalinactiveteach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalactiveclasses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(89, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalregstudents, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(totalactiveStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalinactive, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalteachers, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalactiveteachrs, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalinactiveteach, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(totalactiveclasses, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel31, totalactiveclasses});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(218, 218, 218)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel totalactiveStudents;
    private javax.swing.JLabel totalactiveclasses;
    private javax.swing.JLabel totalactiveteachrs;
    private javax.swing.JLabel totalinactive;
    private javax.swing.JLabel totalinactiveteach;
    private javax.swing.JLabel totalregstudents;
    private javax.swing.JLabel totalteachers;
    // End of variables declaration//GEN-END:variables

}
