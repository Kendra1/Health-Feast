insert into nutrition (id, fat, saturated_fat, cholesterol, sodium, complex_carbs, sugars, protein) values 
(1, 6, 1.8, 53, 0.1, 1.5, 0, 21), --ham
(2, 0.2, 0.2, 0, 0.9, 26, 22, 1.3), --ketchup
(3, 32, 18, 100, 0.16, 3.7, 2.3, 18), -- cheese
(4, 0.3, 0.1, 0, 0.5, 3.3, 2, 3.1), --mushrooms
(5, 5, 2, 0.1, 0.1, 31, 12, 11); --base for pizza

insert into ingredient (id, name, price, calories, sale_id, nutrition_id, vitamin_id, mineral_id, warning, unit) values
(1, "ham", 100, 100, null, 1, null, null, null, "g"),
(2, "ketchup", 50, 97, null, 1, null, null, null, "g"),
(3, "cheese", 300, 404, null, 1, null, null, "Cheese warning", "g"),
(4, "mushrooms", 100, 28, null, 1, null, null, "Mushrooms warning", "g"),
(5, "base", 600, 266, null, 1, null, null, null, "g");

insert into recipe (id, name, preparation_time, instructions, no_of_people, meal_type, kitchen_type, calories) values
(1, "pizza", 30, "instructions", 4, "MAINCOURSE", "ITALIAN", 100),
(2, "Vegeterian pizza", 30, "instructions", 4, "MAINCOURSE", "ITALIAN", 100),
(3, "Margarita pizza", 30, "instructions", 4, "MAINCOURSE", "ITALIAN", 100);

insert into recipe_recommended_recipes(recipe_id, recommended_recipes_id) values
(1, 2),
(1, 3);

--ingredients with quantity for pizza
insert into ingredient_quantity (id, quantity, ingredient_id, specific_ingredient) values
(1, 3, 1, false),
(2, 2, 2, false),
(3, 3, 3, false),
(4, 1.5, 4, false),
(5, 1, 5, false),
(6, 2, 2, false),
(7, 1.5, 4, false),
(8, 1, 5, false),
(9, 2, 2, false),
(10, 1, 5, false);

-- connect ingredients with recipe of pizza
insert into recipe_ingredient_quantity (recipe_id, ingredient_id) values 
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 2),
(2, 4),
(2, 5),
(3, 2),
(3, 5);

-- user
insert into user(id, name, last_name, email, password, role, enabled, account_balance, weight, height, gender, activity, purchase_points, goal, birth_date) values
(1, "user", "last name of user", "user@email.example", "pass", "ROLE_USER", 1, 0.0, 150.0, 190.0, "MALE", "HEAVY", 600.0, "STAGNATE", date('1990-02-02'));

----enter meal history for one date
--insert into meal_history(id, date, user_id) values
--(1, '2020-05-09', 1);
--
--insert into meal_history_meals(meal_history_id, meals_id) values
--(1, 1),
--(1, 2),
--(1, 3),
--(1, 4),
--(1, 5);

--exercises
insert into exercise(id, muscle, name) values 
(1, "gluteus", "squat"),
(2, "hamstring", "lunges"),
(3, "biceps", "biceps flexion"),
(4, "shoulder", "shoulder press"),
(5, "chest", "bench press"),
(6, "body", "running");

insert into exercise_quantity(id, repetitions, exercise_id) values
(1, 10, 1),
(2, 10, 2),
(3, 10, 3),
(4, 10, 4),
(5, 10, 5),
(6, 20, 1),
(7, 20, 2),
(8, 20, 3),
(9, 20, 4),
(10, 20, 5),
(11, 5, 6);

insert into workout(id, calories_burnt, duration, workout_type) values
(1, 300, 90, "MUSCLE"),
(2, 400, 60, "CARDIO" ),
(3, 350, 70, "MIX");

insert into workout_exercises_quantity(workout_id, exercise_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 11),
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(3, 10),
(3, 11);