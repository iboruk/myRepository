package com.luxoft.dbdc.upskilling.implementations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListItemImplTest {

    protected  TodoListItemImpl todoItem;
    protected String title;

    @BeforeAll
    public static void setUpGlobal() {

    }

    @BeforeEach
    public void setUp() {
        title = "Todo List Item for test";
        todoItem = new TodoListItemImpl(title);
    }

    @Test
    public void todoItemIsNotNullAfterCreation() {

    }

    @Test
    public void itemHasAssignedTitleAfterCreation (){
        Assertions.assertTrue(title.equalsIgnoreCase(todoItem.getTitle()));
    }

    @Test
    public void itemHasNewTitleAfterAssignenNewName (){
        String newTitle = "New Title for Todo";
        todoItem.setTitle((newTitle));
        Assertions.assertTrue(()->newTitle.equalsIgnoreCase(todoItem.getTitle()));
    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownGlobal() {

    }

}