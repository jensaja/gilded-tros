# A possible solution to the Gilded Tros Refactoring Kata

This is a solution in Java to the [Gilded Tros Refactoring Kata](https://bitbucket.org/axxesit/gilded-tros/).
The original requirements can be found in GildedTrosRequirements.txt.

## Solution

My solution was committed in 4 branches:
* **unit-tests**: add unit tests without changing the original business logic code
* **refactor**: perform the actual refactor of the business logic code
* **feature-smelly-items**: add the new feature regarding smelly items
* **documentation**: add some documentation

The main idea behind my refactor is to have an abstract `ItemUpdater` class that contains the item and allows to perform updates on it. Its final subclasses implement the `update` method, which performs the update logic on the `Item`'s quality and sellIn values depending on the item type.

![class diagram](GildedTrosClassUML.png?raw=true "class diagram")

The `GildedTros::updateQuality` method simply loops through all `items`, creates an `ItemUpdater` object with `ItemUpdaterFactory` (actual class depends on detected item type) and calls its `update` method.