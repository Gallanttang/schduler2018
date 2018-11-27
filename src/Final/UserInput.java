package Final;

import model.Meal;
import model.WorkOut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;

public class UserInput {
    final JPanel buttonPane = new JPanel(new GridLayout(1, 4));;
    HandleSchedule hs;

    public UserInput(HandleSchedule hs){
        this.hs = hs;
        toggleChange();
    }

    public void toggleChange() {
        JButton add_event = new JButton("Add Event");
        JButton remove_event = new JButton("Remove Event");
        JButton save_plan = new JButton("Save Plan");
        JButton load_plan = new JButton("Load Plan");

        buttonPane.removeAll();

        buttonPane.add(add_event);
        buttonPane.add(remove_event);
        buttonPane.add(save_plan);
        buttonPane.add(load_plan);

        add_event.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputAddEvent();
            }
        });

        remove_event.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputRemoveEvent();
            }
        });

        save_plan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputSave();
            }
        });

        load_plan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputLoad();
            }
        });
    }

    private void userInputSave() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What will you name this plan?"), BorderLayout.LINE_START);
        JTextField name = new JTextField(15);
        JButton confirmBtn = new JButton("confirm");

        buttonPane.add(name);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().isEmpty()) {
                    Path path = hs.createPlans(name.getText());
                    try {
                        toggleChange();
                        hs.getWs().save(path);
                        JFrame pop = new JFrame("Completed");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void userInputLoad() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What is the plan you want to load?"), BorderLayout.LINE_START);
        JTextField name = new JTextField(15);
        JButton confirmBtn = new JButton("confirm");

        buttonPane.add(name);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().isEmpty()) {
                    Path path = hs.loadPlan(name.getText());
                    try {
                        toggleChange();
                        hs.getWs().load(path);
                        JFrame pop = new JFrame("Completed");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void userInputAddEvent() {
        buttonPane.removeAll();
        JButton woOption = new JButton("Add a workout");
        JButton mOption = new JButton("Add a meal");
        JButton back = new JButton("Go back to menu");
        buttonPane.add(woOption);
        buttonPane.add(mOption);
        buttonPane.add(back);

        woOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputAddWO();
            }
        });

        mOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputAddMeal();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputBack();
            }
        });
    }

    private void userInputAddWO() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What body part are you working out?"), BorderLayout.LINE_START);
        JTextField woParam = new JTextField(15);
        JButton confirmBtn = new JButton("confirm");
        JButton back = new JButton("Go back to menu");

        buttonPane.add(woParam);
        buttonPane.add(confirmBtn);
        buttonPane.add(back);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!woParam.getText().isEmpty()) {
                    userInputAddWOTime(woParam.getText());
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputBack();
            }
        });
    }

    private void userInputAddWOTime(String name) {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What time do you want to work out?"), BorderLayout.LINE_START);
        JTextField woParam = new JTextField(1);
        JButton confirmBtn = new JButton("confirm");
        buttonPane.add(woParam);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!woParam.getText().isEmpty()) {
                    try {
                        int time = Integer.parseInt(woParam.getText());
                        userInputAddWOPlan(name, time);
                    } catch (NumberFormatException e1) {
                        JFrame pop = new JFrame("Invalid entry");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                        userInputAddWOTime(name);
                    }

                }
            }
        });
    }

    private void userInputAddWOPlan(String name, int time) {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What is the plan?"), BorderLayout.LINE_START);

        JTextField woParam = new JTextField(1);

        JButton confirmBtn = new JButton("confirm");

        buttonPane.add(woParam);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!woParam.getText().isEmpty()) {
                    String plan = woParam.getText();
                    userInputAddWODay(name, time, plan);
                }
            }
        });
    }

    private void userInputAddWODay(String name, int time, String plan) {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("On which day?"), BorderLayout.LINE_START);

        JTextField woParam = new JTextField(10);

        JButton confirmBtn = new JButton("confirm");

        buttonPane.add(woParam);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!woParam.getText().isEmpty()) {
                    String day = woParam.getText();
                    if(checkValidDay(day)){
                    WorkOut wo = new WorkOut(name,time,plan,day);
                    hs.getWs().putWorkOut(wo);
                    toggleChange();
                    JFrame pop = new JFrame("Completed");
                    pop.setSize(200, 10);
                    pop.setVisible(true);
                    } else {
                        JFrame pop = new JFrame("Not a valid day");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                        woParam.setText("");
                    }
                }
            }
        });
    }

    private void userInputAddMeal() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What will you name this meal?"), BorderLayout.LINE_START);
        JTextField mParam = new JTextField(15);
        JButton confirmBtn = new JButton("confirm");
        JButton back = new JButton("Go back to menu");
        buttonPane.add(mParam);
        buttonPane.add(confirmBtn);
        buttonPane.add(back);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mParam.getText().isEmpty()) {
                    userInputAddMealTime(mParam.getText());
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputBack();
            }
        });
    }

    private void userInputAddMealTime(String name) {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("When will this meal be?"), BorderLayout.LINE_START);
        JTextField mParam = new JTextField(1);
        JButton confirmBtn = new JButton("confirm");
        buttonPane.add(mParam);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mParam.getText().isEmpty()) {
                    try {
                        int time = Integer.parseInt(mParam.getText());
                        userInputAddMealPlan(name, time);
                    } catch (NumberFormatException e1) {
                        JFrame pop = new JFrame("Invalid entry");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                        userInputAddMealTime(name);
                    }

                }
            }
        });
    }

    private void userInputAddMealPlan(String name, int time) {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("What is the plan?"), BorderLayout.LINE_START);

        JTextField mParam = new JTextField(1);

        JButton confirmBtn = new JButton("confirm");

        buttonPane.add(mParam);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mParam.getText().isEmpty()) {
                    String plan = mParam.getText();
                    Meal m = new Meal(name,time,plan);
                    hs.getWs().putMeal(m);
                    toggleChange();
                    JFrame pop = new JFrame("Completed");
                    pop.setSize(200, 10);
                    pop.setVisible(true);
                }
            }
        });
    }

    private void userInputRemoveEvent() {
        buttonPane.removeAll();

        buttonPane.add(new JLabel("What kind of event are you trying to remove?"), BorderLayout.NORTH);

        JButton meal = new JButton("Meal");
        JButton workOut = new JButton("Work Out");
        JButton back = new JButton("Go back to menu");
        JPanel buttons = new JPanel();
        buttons.add(meal);
        buttons.add(workOut);
        buttons.add(back);

        buttonPane.add(buttons);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputBack();
            }
        });

        workOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputRemoveWorkOut();
            }
        });

        meal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputRemoveMeal();
            }
        });
    }

    private void userInputRemoveMeal() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("Which meal are you trying to remove?"), BorderLayout.LINE_START);
        JButton confirmBtn = new JButton("confirm");


        JTextField param = new JTextField(15);
        buttonPane.add(param);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!param.getText().isEmpty()){
                    if(hs.getWs().removeMeal(param.getText())){
                        toggleChange();
                        JFrame pop = new JFrame("Completed");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                    } else {
                        userInputRemoveMeal();
                        JFrame pop = new JFrame("That meal does not exist.");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                        userInputRemoveMeal();
                    }
                }
            }
        });
    }

    private void userInputRemoveWorkOut() {
        buttonPane.removeAll();
        buttonPane.add(new JLabel("Which work out are you trying to remove?"), BorderLayout.LINE_START);
        JButton confirmBtn = new JButton("confirm");


        JTextField param = new JTextField(15);
        buttonPane.add(param);
        buttonPane.add(confirmBtn);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!param.getText().isEmpty()){
                    if(hs.getWs().removeWorkOut(param.getText())){
                        toggleChange();
                        JFrame pop = new JFrame("Completed");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                    } else {
                        userInputRemoveMeal();
                        JFrame pop = new JFrame("That workout does not exist.");
                        pop.setSize(200, 10);
                        pop.setVisible(true);
                        userInputRemoveMeal();
                    }
                }
            }
        });
    }


    private void userInputBack() {
        toggleChange();
    }


    private boolean checkValidDay(String newDay) {
        return newDay.equals("Monday") || newDay.equals("Tuesday") || newDay.equals("Wednesday") || newDay.equals("Thursday") ||
                newDay.equals("Friday") || newDay.equals("Saturday") || newDay.equals("Sunday");
    }
}
