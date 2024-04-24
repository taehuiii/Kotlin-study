data class Item(
    val name: String,
    val weight: Int,
)

class Bag(
    val maxWeight: Int,
) {
    init {
        if (maxWeight <= 0) {
            throw Exception("가방의 최대 무게가 잘못 설정되었습니다.")
        }
    }

    val itemList: MutableList<Item> = mutableListOf()
    var currentWeight = this.itemList.fold(0) { acc, item -> acc + item.weight }

    fun putItem(item: Item) {
        if (item.weight + currentWeight > maxWeight) {
            throw Exception("가방에 아이템을 넣을 수 없습니다.")
        }

        this.itemList.add(item)
    }

    fun removeItem(item: Item) {
        this.itemList.remove(item)
    }


}
