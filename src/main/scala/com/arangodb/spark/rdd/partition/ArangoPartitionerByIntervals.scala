package com.arangodb.spark.rdd.partition

import com.arangodb.spark.ReadOptions

sealed trait ArangoPartitionerByIntervals[A] extends ArangoPartitioner {

  val splitPoints: Seq[A]

  /*
  - split-points, always left-inclusive, right-exclusive (until last if not null)
  - may contain null at first or at last, but not within
  - need to be in ascending order and non-equal
  - configure whether all lower than first gets its own partition, same for all larger than last
  - configure whether to produce "product-partitions" with shards additional to keys
  */


  def createPartitions(options: ReadOptions): Array[ArangoPartition] = {

    // check whether index-field is skipList
    // check whether

    Array(createPartition(0, Array(), options))

  }
}

object ArangoPartitionerByIntervals {
  /*
  def forNumericSplitPoints(points: Seq[Double]): ArangoParitionerBySkiplistRange = {
    new ArangoParitionerBySkiplistRange()
  }
  */
}

class ArangoPartitionerByDoubleIntervals extends ArangoPartitionerByIntervals[Double] {
  val splitPoints: Seq[Double] = Seq.empty
}

class ArangoPartitionerByStringIntervals extends ArangoPartitionerByIntervals[String] {
  val splitPoints: Seq[String] = Seq.empty
}


//
//class ArangoPartitionerByIntervals extends ArangoPartitioner {
//
//  val splitPoints: Seq[Double]
//
//  /*
//  - split-points, always left-inclusive, right-exclusive
//  - configure whether all lower than first gets its own partition, same for all larger than last
//  - configure whether to produce "product-partitions" with shards additional to keys
//  */
//
//
//  def createPartitions(options: ReadOptions): Array[ArangoPartition] = {
//
//    // check whether index-field is skipList
//    // check whether
//
//    Array(createPartition(0, Array(), options))
//
//  }
//}

