import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe

class BagTest : BehaviorSpec({

    Given("a valid max weight") {
        val validMaxWeight = 10

        When("execute constructor") {
            val result = Bag(validMaxWeight)

            Then("max weight should be valid max weight") {
                result.maxWeight shouldBe validMaxWeight
            }
        }
    }

    Given("a max weight = 0") {
        val maxWeight = 0

        When("execute constructor") {
            val exception = shouldThrow<Exception> { Bag(maxWeight) }

            Then("exception message should be expected") {
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."
            }
        }
    }

    Given("a max weight is negative") {
        val maxWeight = -10

        When("execute constructor") {
            val exception = shouldThrow<Exception> { Bag(maxWeight) }

            Then("exception message should be expected") {
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."
            }
        }
    }

    Given("maxWeigth을 넘을 때"){
       val bag = Bag(10)
        val item =Item("book",100)

        When("putItem을 하면"){
            val exception = shouldThrow<Exception> { bag.putItem(item) }

            Then("exception msg should be expected "){
                exception.message shouldBe "가방에 아이템을 넣을 수 없습니다."
            }
        }
    }

    Given("maxWeight를 넘지 않을 때"){
        val bag = Bag(100)
        val item = Item("cup", 25)

        When(" excute putItem "){
            bag.putItem(item)

            Then("add to itemList"){
                bag.itemList.size shouldBe 1
                bag.itemList.first() shouldBe item
            }
        }

    }

    Given ("a bag has an item"){
        val bag = Bag(100)
        val item = Item("mouse", 20)
        bag.putItem(item)

        When("remove item"){
            bag.removeItem(item)

            Then("can't find item"){
                bag.itemList.size shouldBe 0
            }
        }
    }

    Given("a bag has many items"){
        val bag = Bag(100)

        val itemList = listOf(
            Item("red",1),
            Item("yellow",2),
            Item("green",3),
            Item("blue",4)
        )

        itemList.forEach{
            bag.putItem(it)
        }

        When("remove do it!"){
            val targetItem = itemList[1]
            bag.removeItem(targetItem)

            Then(" it's gone.."){
                bag.itemList.size shouldBe itemList.size-1
                bag.itemList shouldNotContain targetItem
            }
        }
    }

})






