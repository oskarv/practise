$(function () {

    var Person = Backbone.Model.extend({

        defaults: {
            firstName: 'Pera',
            lastName: 'Peric',
            checked: false
        },

        toggle: function () {
            this.set('checked', !this.get('checked'));
        }
    });

    var PersonList = Backbone.Collection.extend({

        model: Person,

        getChecked: function () {
            return this.where({checked: true});
        }
    });

    var persons = new PersonList([
        new Person({firstName: 'Nemanja', lastName: 'Jeremic'}),
        new Person({firstName: 'Tanja', lastName: 'Stevic'}),
        new Person({firstName: 'Sanja', lastName: 'Micic'}),
        new Person({firstName: 'Nevena', lastName: 'Savic'})
    ]);

    var PersonView = Backbone.View.extend({
        tagName: 'li',

        events: {
            'click': 'toggleService'
        },

        initialize: function () {

            this.listenTo(this.model, 'change', this.render);
        },

        render: function () {

            this.$el.html('<input type="checkbox" value="1" name="name" /> ' + this.model.get('firstName') + this.model.get('lastName'));
            this.$('input').prop('checked', this.model.get('checked'));

            return this;
        },

        toggleService: function () {
            this.model.toggle();
        }
    });

    var App = Backbone.View.extend({

        el: $('#main'),

        initialize: function () {

            this.selectedPersonsString = $('#selectedPersons');
            this.list = $('#persons');

            this.listenTo(persons, 'change', this.render);

            persons.each(function (person) {

                var view = new PersonView({model: person});
                this.list.append(view.render().el);

            }, this);
        },

        render: function () {

            var selectedPersons = "";

            _.each(persons.getChecked(), function (elem) {
                selectedPersons += elem.get('firstName') + elem.get('lastName') + " ";
            });

            this.selectedPersonsString.text(selectedPersons);

            return this;
        },

        events: {
            'click #submitButton': 'removeFunction'
        },

        removeFunction: function () {
            this.remove();
            new Third().render();
        }
    });

    var Third = Backbone.View.extend({

        el: $('#third'),

        initialize: function () {

        },

        render: function () {

            var list = $('#selected');

            persons.each(function (person) {
                console.log(person);
                if (person.attributes.checked === true) {
                    list.append("<li>" + person.attributes.firstName + person.attributes.lastName + "</li>");
                }

            }, this);

            return this;
        }
    });

    new App();

});